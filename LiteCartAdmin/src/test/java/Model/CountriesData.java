package Model;

import java.util.Objects;

public class CountriesData {
    private String name;
    private int id;
    private String code;
    private String currencyCode;
    private int phoneCode;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public int getPhoneCode() {
        return phoneCode;
    }

    public CountriesData withName(String name) {
        this.name = name;
        return this;
    }

    public CountriesData withId(int id) {
        this.id = id;
        return this;
    }

    public CountriesData withCode(String code) {
        this.code = code;
        return this;
    }

    public CountriesData withCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public CountriesData withPhoneCode(int phoneCode) {
        this.phoneCode = phoneCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountriesData that = (CountriesData) o;
        return id == that.id &&
                phoneCode == that.phoneCode &&
                Objects.equals(name, that.name) &&
                Objects.equals(code, that.code) &&
                Objects.equals(currencyCode, that.currencyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, code, currencyCode, phoneCode);
    }
}
