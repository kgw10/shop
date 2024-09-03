package com.shop.Control;

import com.shop.Dto.OrderHistDto;
import com.shop.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping(value = {"/orderList", "/orderList/{page}"})
    public String orderList(@PathVariable("page")Optional<Integer> page, Principal principal, Model model) {

        // 페이징을 위한 코드
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0,5);
        // PageRequest.of( 몇 번재 페이지, 한 페이지에 몇 개);
        // isPresent -> 값이 있나?
        Page<OrderHistDto> orderHistDtos = orderService.getOrderList(principal.getName(), pageable);

        model.addAttribute("orders", orderHistDtos);
        model.addAttribute("page", pageable.getPageNumber());
        model.addAttribute("maxPage", 5);

        return "order/order";
    }
}
