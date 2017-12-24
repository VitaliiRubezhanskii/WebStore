package beans;
    import javax.persistence.*;

    @Entity
    @Table(name = "countrylanguage")
        public class CountryLanguage extends  AbstractWorld {
    @Id
        private String language;

    @Column(name="CountryCode")
        private String countryCode;

    @Column(name="IsOfficial")
        private String isOfficial;

    @Column(name="Percentage")
    private double Percentage;

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public void setPercentage(double percentage) {
        Percentage = percentage;
    }

    public String getCountryCode() {

        return countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public double getPercentage() {
        return Percentage;
    }
}
