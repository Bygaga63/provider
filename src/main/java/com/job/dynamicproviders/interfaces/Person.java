package com.job.dynamicproviders.interfaces;

import java.util.List;

public interface Person {
    String getId();

    String getEmail();

    void setEmail(String email);

    String getPhone();

    void setPhone(String phone);

    String getDisplayName();

    void setDisplayName(String displayName);

    String getAboutMe();

    void setAboutMe(String aboutMe);

    String getPreferredName();

    void setPreferredName(String preferredName);

    String getStatus();

    void setStatus(String status);

    String getAdditionalName();

    void setAdditionalName(String additionalName);

    String getFamilyName();

    void setFamilyName(String familyName);

    String getGivenName();

    void setGivenName(String givenName);

    String getHonorificPrefix();

    void setHonorificPrefix(String honorificPrefix);

    String getHonorificSuffix();

    void setHonorificSuffix(String honorificSuffix);


    void setLogin(String login);

    String getLogin();
}
