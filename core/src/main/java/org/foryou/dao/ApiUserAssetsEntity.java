package org.foryou.dao;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "api_user_assets", schema = "demo")
public class ApiUserAssetsEntity {
    private int id;
    private String account;
    private BigDecimal money;
    private BigDecimal bitcoin;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "money")
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Column(name = "bitcoin")
    public BigDecimal getBitcoin() {
        return bitcoin;
    }

    public void setBitcoin(BigDecimal bitcoin) {
        this.bitcoin = bitcoin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiUserAssetsEntity that = (ApiUserAssetsEntity) o;
        return id == that.id &&
                Objects.equals(account, that.account) &&
                Objects.equals(money, that.money) &&
                Objects.equals(bitcoin, that.bitcoin);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, account, money, bitcoin);
    }
}
