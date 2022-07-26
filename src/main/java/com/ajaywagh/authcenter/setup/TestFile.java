package com.ajaywagh.authcenter.setup;

import com.ajaywagh.authcenter.POJO.App;
import com.ajaywagh.authcenter.POJO.AppPermission;
import com.ajaywagh.authcenter.repositories.AppPermissionRepository;
import com.ajaywagh.authcenter.repositories.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

//@Component
public class TestFile {
    //@Autowired
    AppPermissionRepository appPermissionRepository;
    //@Autowired
    AppRepository appRepository;

    //@EventListener(ApplicationReadyEvent.class)
    public void test(){
        AppPermission appPermission=new AppPermission();
        appPermission.setPermission("Create");
        appPermissionRepository.saveAndFlush(appPermission);

        AppPermission appPermission2=new AppPermission();
        appPermission2.setPermission("Update");
        appPermissionRepository.saveAndFlush(appPermission2);

        Set<AppPermission> set=new HashSet<>();
        set.add(appPermission);
        set.add(appPermission2);

        App app=new App("1","tkgfhgfgf",set);
        appRepository.saveAndFlush(app);

    }
}
