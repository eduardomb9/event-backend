package br.gov.ce.arce.estagio.evento.controller;

import br.gov.ce.arce.estagio.evento.EmailConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/mail")
public class MailController {

    private EmailConfig emailConfig;

    public MailController(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    @RequestMapping(value = "/{emailTo}", method = RequestMethod.GET)
    public ResponseEntity enviarEmail(@PathVariable("emailTo") String emailTo) {

        // Creating email sender instance
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());


        // Creating email
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("email@email.com");
        mailMessage.setTo(emailTo);
        mailMessage.setSubject("Email from Spring Boot");
        mailMessage.setText("Olá.");

        mailSender.send(mailMessage);

        return ResponseEntity.ok("email enviado com sucesso");
    }
}
