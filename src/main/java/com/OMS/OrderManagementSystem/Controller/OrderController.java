package com.OMS.OrderManagementSystem.Controller;




import com.OMS.OrderManagementSystem.OrderService;
import model.CurrentStatus;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/orders")
    public class OrderController {

        @Autowired
        private OrderService orderService;

        @PostMapping
        public ResponseEntity<?> createOrder( @RequestBody Order order) {
            try {
                Order createdOrder = orderService.omsCreateOrder(order);
                return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
            }
            catch (Exception e) {
                return new ResponseEntity<>("Error creating order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @GetMapping("/{orderId}")
        public ResponseEntity<?> getOrder(@PathVariable Long orderId) {
            try {
                Order order = orderService.omsPrepareOrder(orderId);
                if (order != null) {
                    return new ResponseEntity<>(order, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity<>("Error fetching order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PatchMapping("/{orderId}/status")
        public ResponseEntity<?> updateOrderStatus(@PathVariable Long orderId, @RequestParam CurrentStatus status) {
       try{     Order updatedOrder = orderService.omsUpdateCurrentStatus(orderId, status);
            if (updatedOrder != null) {
                return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
       catch (Exception e) {
           return new ResponseEntity<>("Error updating order status: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
       }
        }

        @DeleteMapping("/{orderId}")
        public ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
            try{
            orderService.omsPostponeorder(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>("Error cancelling order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


