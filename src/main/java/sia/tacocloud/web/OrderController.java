package sia.tacocloud.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import sia.tacocloud.TacoOrder;
import sia.tacocloud.data.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(){
        // Url http://localhost:8080/orders/current
        return "orderForm"; //orderForm.html
    }

    // No this method in BOOK
    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               SessionStatus sessionStatus){

        log.info("orderRepo save order 1");

        if(errors.hasErrors()){
            return "orderForm";
        }

        //log.info("Order submitted: {}", order); // show in console

        log.info("orderRepo save order");
        orderRepo.save(order);

        log.info("orderRepo save order ok");

        sessionStatus.setComplete();

        return "redirect:/";
    }
}
