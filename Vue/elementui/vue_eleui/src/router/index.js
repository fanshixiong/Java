import Vue from 'vue'
import Router from 'vue-router'

import Main from '../views/Main'
import Login from '../views/Login'

import UserList from "../views/user/List";
import UserProfile from "../views/user/Profile";
import NotFoune from "../views/error/NotFoune";

Vue.use(Router)

export default new Router({
    mode : 'history',
    routes: [
        {
            path: '/login',
            component: Login,
        },
        {
            path: '/logout',
            redirect : '/login'
        },
        {
            // path: '/main/:name',
            path: '/main',
            component: Main,
            props : true ,
            //路由嵌套
            children: [
                {
                    // path: '/user/profile/:id',
                    path: '/user/profile',
                    component: UserProfile,
                    name : 'UserProfile',
                    props : true
                },
                {
                    path: '/user/list',
                    component:  UserList
                },
            ]
        },
        {
            path: '/back',
            redirect: '/main'
        },
        {
            path: '*',
            component : NotFoune,
        }
    ]
})
