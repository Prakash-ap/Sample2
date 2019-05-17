package techy.ap.sample2;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

public class Population {
    @SerializedName("rank")
    private Integer rank;
    @SerializedName("country")
    private String country;
    @SerializedName("flag")
    private String flag;

    public Population(Integer rank, String country, String flag) {
        this.rank = rank;
        this.country = country;
        this.flag = flag;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
