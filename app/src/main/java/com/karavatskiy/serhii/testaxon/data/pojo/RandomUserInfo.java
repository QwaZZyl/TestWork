
package com.karavatskiy.serhii.testaxon.data.pojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomUserInfo {

    @SerializedName("results")
    @Expose
    private List<UserInfo> results = null;
    @SerializedName("info")
    @Expose
    private Info info;

    public List<UserInfo> getResults() {
        return results;
    }

    public void setResults(List<UserInfo> usersInfo) {
        this.results = usersInfo;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
