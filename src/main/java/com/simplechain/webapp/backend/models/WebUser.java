package com.simplechain.webapp.backend.models;


import com.simplechain.webapp.backend.utils.Encryptor;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WebUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String password;
    private String address;

    public WebUser(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = "0x_" + Encryptor.getSHA256String(name + email);
    }
}
