package beans;
import javax.persistence.*;

@Entity
    @Table(name = "City")
        public class City {
    @Id

    //@GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
    @Column(name="Name")
        private String name;

@Column(name="CountryCode")
        public String countryCode;

    @Column(name = "District")
        private String district;

    @Column(name = "Population")
        private Integer population;



        public City() {
        }


        public City(Integer id,String name,String countryCode, String district, Integer population) {
            this.id=id;
            this.name = name;
            this.countryCode=countryCode;
            this.district = district;
            this.population=population;
        }

        public int getId(){return id;}

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", CountryCode='" + countryCode + '\'' +
                ", District='" + district + '\'' +
                ", Population=" + population +
                '}';
    }
}
