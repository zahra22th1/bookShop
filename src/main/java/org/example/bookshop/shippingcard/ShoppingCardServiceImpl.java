package org.example.bookshop.shippingcard;


import org.example.bookshop.dto.response.ShoppingCardResponse;
import org.example.bookshop.dto.resquest.ShoppingCardRequest;
import org.example.bookshop.excepion.RuleException;
import org.example.bookshop.model.*;
import org.example.bookshop.repository.BookRepository;
import org.example.bookshop.repository.FactorRepository;
import org.example.bookshop.repository.ShopingRepository;
import org.example.bookshop.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {

    //Autowiring
    private final FactorRepository factorRepository;
    private final ShopingRepository shopingRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ShoppingCardServiceImpl(FactorRepository factorRepository, ShopingRepository shopingRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.factorRepository = factorRepository;
        this.shopingRepository = shopingRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public ShoppingCardResponse addShoppingCard(ShoppingCardRequest shoppingCardRequest) {
       User user = userRepository.findById(shoppingCardRequest.getUserId())
                .orElseThrow(() -> new RuleException("{user.not.found}"));
       Book book =  bookRepository.findById(shoppingCardRequest.getBookId())
                .orElseThrow(() -> new RuleException("{book.not.found}"));
        Optional<Factor> byId = factorRepository.findByUserAndPaid(user, Paid.UNPAID);

        Factor factor;
        factor = byId.orElseGet(() -> createFactor(user));
        factorRepository.save(factor);
        ShoppingCard shoppingCard = createShoppingCard(shoppingCardRequest,book, factor);
                return      createShoppingCardResponse(shopingRepository.save(shoppingCard));

    }

    private ShoppingCardResponse createShoppingCardResponse(ShoppingCard save) {
        return ShoppingCardResponse.builder()
                .factorId(save.getFactor().getId())
                .shoppingCardId(save.getId())
                .build();
    }

    private Factor createFactor(User user) {
       return Factor.builder()
                .user(user)
                .paid(Paid.UNPAID)
                .build();
    }

    private ShoppingCard createShoppingCard(ShoppingCardRequest shoppingCardRequest, Book book, Factor factor) {
      return   ShoppingCard.builder()
                .book(book)
                .factor(factor)
                .count(shoppingCardRequest.getCount())
                .build();

    }
}
