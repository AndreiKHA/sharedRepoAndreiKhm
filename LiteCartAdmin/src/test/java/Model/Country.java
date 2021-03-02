package Model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Country extends ForwardingSet<CountriesData> {
    private Set<CountriesData> delegate;

    public Country(Country countries) {
        this.delegate = new HashSet<CountriesData>(countries.delegate);
    }

    public Country() {
        this.delegate = new HashSet<CountriesData>();
    }

    public Country(Collection<CountriesData> countries) {
        this.delegate = new HashSet<CountriesData>(countries);
    }

    @Override
    protected Set<CountriesData> delegate() {
        return delegate;
    }

    public Country withAdded(CountriesData country) {
        Country countries = new Country(this);
        countries.add(country);
        return countries;
    }

    public Country without(CountriesData country) {
        Country countries = new Country(this);
        countries.remove(country);
        return countries;
    }

}
