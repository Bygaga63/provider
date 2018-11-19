package com.job.dynamicproviders.web.controller;

import com.job.dynamicproviders.model.JpaUser;
import com.job.dynamicproviders.model.groups.*;
import com.job.dynamicproviders.repository.GroupSocialRepository;
import com.job.dynamicproviders.repository.UserRepository;
import com.job.dynamicproviders.repository.UserGroupRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private GroupSocialRepository groupRepository;
    private UserRepository userRepo;
    private UserGroupRepo userGroupRepo;
    @GetMapping("")
    public List<JpaGroupSocial> getGroupList(){
        List<JpaGroupSocial> all = groupRepository.findAll();
        return all;
    }


    @GetMapping("/woman")
    public GroupSocial createWoman(){


//        JpaUser user1 = JpaUser.builder().username("Dima").build();
//        userRepo.save(user1);
        List<JpaUser> users = userRepo.findAll();

        JpaUser owner = users.get(0);
        JpaGroupType womanGroup = new JpaGroupType();
        womanGroup.setName("только девочки");
        womanGroup.setAccess(GroupTypeAccess.Public);

        //create group
        JpaGroupSocial eightMarch = new JpaGroupSocial();
        eightMarch.setType(womanGroup);
        eightMarch.setDescription("Кого поздравлять 8 марта");
        eightMarch.setName("8 Марта");

        eightMarch.setUser(owner);

        //create group users
        JpaGroupSocial group = groupRepository.save(eightMarch);

        JpaUserGroup personGroup = new JpaUserGroup();
        personGroup.setGroup(group);
        personGroup.setUser(owner);
        personGroup.setRole(PersonGroupRole.Master);

        List<JpaUserGroup> jpaUserGroups = addUsersToGroup(users, group);

        //save owner
        userGroupRepo.save(personGroup);

        //save users
        userGroupRepo.saveAll(jpaUserGroups);

        return group;
    }


    @GetMapping("/{id}")
    public List<JpaUserGroup> getGroup(@PathVariable String id) {
        JpaGroupSocial group = groupRepository.findById(Long.parseLong(id)).get();
//        return group.get();
        System.out.println(id);
        return userGroupRepo.findAllByGroup(group);
//        return userGroupRepo.find(1L);
    }

    private List<JpaUserGroup> addUsersToGroup(List<JpaUser> users, JpaGroupSocial groupSocial) {
        List<JpaUserGroup> userList = new ArrayList<>();
        users.remove(0);
        users.forEach(user -> {
            JpaUserGroup jpaUserGroup = new JpaUserGroup();
            jpaUserGroup.setGroup(groupSocial);
            jpaUserGroup.setRole(PersonGroupRole.User);
            jpaUserGroup.setUser(user);
            userList.add(jpaUserGroup);
        });

        return userList;
    }

    @GetMapping("/man")
    public GroupSocial createMan(){

        JpaGroupType manGroup = new JpaGroupType();
        manGroup.setName("только мальчики");
        manGroup.setAccess(GroupTypeAccess.Public);

        JpaGroupSocial fab = new JpaGroupSocial();
        fab.setType(manGroup);
        fab.setDescription("Кого поздравлять 23 февраля");
        fab.setName("23 февраля");

        Optional<JpaUser> jpaUser = userRepo.findById(1l);
        fab.setUser(jpaUser.get());

        JpaGroupSocial result = groupRepository.save(fab);

        return result;
    }



}
