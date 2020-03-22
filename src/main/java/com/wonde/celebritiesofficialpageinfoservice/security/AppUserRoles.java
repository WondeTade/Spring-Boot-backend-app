package com.wonde.celebritiesofficialpageinfoservice.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.wonde.celebritiesofficialpageinfoservice.security.AppUserPermission.*;

public enum AppUserRoles {

    ADMIN(Sets.newHashSet(USER_WRITE, USER_READ)),
    USER(Sets.newHashSet(USER_READ, USER_WRITE)),
    GUEST(Sets.newHashSet());

    private final Set<AppUserPermission> appUserPermissions;

    AppUserRoles(Set<AppUserPermission> appUserPermissions) {
        this.appUserPermissions = appUserPermissions;
    }

    public Set<AppUserPermission> getAppUserPermissions() {
        return appUserPermissions;
    }
}
