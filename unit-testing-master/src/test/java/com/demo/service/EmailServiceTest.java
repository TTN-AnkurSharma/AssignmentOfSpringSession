package com.demo.service;

import com.demo.domain.Order;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class EmailServiceTest {

    private EmailService emailService;
    private Order order;

    @Before
    public void setUp() {
        emailService = EmailService.getInstance();
        order = mock(Order.class);
    }

    @Test
   public void testSendEmail_ThrowsException() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> emailService.sendEmail(order));
        assertEquals("An Exception Occurred", exception.getMessage());

        verify(order).setCustomerNotified(false);
        verify(order, never()).setCustomerNotified(true);
    }

    @Test
    public void testSendEmailWithCC_Success() {
        boolean result = emailService.sendEmail(order, "test@gmail.com");
        assertTrue(result);
        verify(order).setCustomerNotified(true);
    }

    @Test
    public void testSingletonInstance() {
        EmailService instance1 = EmailService.getInstance();
        EmailService instance2 = EmailService.getInstance();
        assertSame(instance1, instance2);
    }




}