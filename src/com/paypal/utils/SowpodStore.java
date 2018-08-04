package com.paypal.utils;

import java.util.List;

public class SowpodStore {
    private static SowpodStore ourInstance = new SowpodStore();
    private List<String> sowpodList;

    public static SowpodStore getInstance() {
        return ourInstance;
    }

    private SowpodStore() {
    }

    public List<String> getSowpodList() {
        return sowpodList;
    }

    public void setSowpodList(List<String> sowpodList) {
        this.sowpodList = sowpodList;
    }
}
