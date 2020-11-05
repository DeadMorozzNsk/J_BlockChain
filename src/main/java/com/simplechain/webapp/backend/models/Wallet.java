package com.simplechain.webapp.backend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.simplechain.webapp.backend.utils.Encryptor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "wallets")
@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double balance;
    private String address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private WebUser owner;

    public Wallet(WebUser owner) {
        this.owner = owner;
        this.address = "0x_" + Encryptor.getSHA256String(owner.getName() + "@" + owner.getEmail());
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", balance=" + balance +
                ", address='" + address + '\'' +
                ", owner=" + owner +
                '}';
    }
}
