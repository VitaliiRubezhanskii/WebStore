    package beans;
    import javax.persistence.*;
    @Entity
    @Table(name = "country")
        public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

        private String code;
    @Column(name="Name")
        private String name;
    @Column(name="Continent")
        private String continent;
    @Column(name="Region")
        private String region;
    @Column(name="SurfaceArea")
        private double surfaceArea;
    @Column(name="IndepYear")
        private int indepYear;
    @Column(name="Population")
        private int population;
    @Column(name="LifeExpectancy")
        private double lifeExpectancy;
    @Column(name="GNP")
        private double GNP;
    @Column(name="GNPOld")
         private double GNPOld;
    @Column(name="LocalName")
        private String localName;
    @Column(name="GovernmentForm")
    private String governmentForm;
    @Column(name="HeadOfState")
        private String HeadOfState;
    @Column(name="Capital")
        private int capital;
    @Column(name="Code2")
        private String code_two;


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public String getRegion() {
        return region;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public int getIndepYear() {
        return indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public double getGNP() {
        return GNP;
    }

    public double getGNPOld() {
        return GNPOld;
    }

    public String getLocalName() {
        return localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public String getHeadOfState() {
        return HeadOfState;
    }

    public int getCapital() {
        return capital;
    }

    public String getCode_two() {
        return code_two;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setLifeExpectancy(double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public void setGNP(double GNP) {
        this.GNP = GNP;
    }

    public void setGNPOld(double GNPOld) {
        this.GNPOld = GNPOld;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public void setHeadOfState(String headOfState) {
        HeadOfState = headOfState;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setCode_two(String code_two) {
        this.code_two = code_two;
    }
}


