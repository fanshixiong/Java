<template>
    <div>
        <el-container>
            <el-aside width="200px">
                <el-menu :default-openeds="['1']">
                    <el-submenu index="1">
                        <template slot="title"><i class="el-icon-caret-right"></i>用户管理</template>
                        <el-menu-item-group>
                            <el-menu-item index="1-1">
                                <!--插入的地方-->
                                <!--<router-link :to="{name : 'UserProfile', params : {id : 1}}">个人信息</router-link>-->
                                <router-link to="/user/profile">个人信息</router-link>
                            </el-menu-item>
                            <el-menu-item index="1-2">
                                <!--插入的地方-->
                                <router-link to="/user/list">用户列表</router-link>
                            </el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="2">
                        <template slot="title"><i class="el-icon-caret-right"></i>内容管理</template>
                        <el-menu-item-group>
                            <el-menu-item index="2-1">分类管理</el-menu-item>
                            <el-menu-item index="2-2">内容列表</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                    <el-submenu index="3">
                        <template slot="title"><i class="el-icon-caret-right"></i>返回</template>
                        <el-menu-item-group>
                            <el-menu-item index="3-1">返回</el-menu-item>
                            <el-menu-item index="3-2">
                                <router-link to="/back">回到首页</router-link>
                            </el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                </el-menu>
            </el-aside>

            <el-container>
                <el-header style="text-align: right; font-size: 12px">
                    <el-dropdown>
                        <i class="el-icon-setting" style="margin-right: 15px"></i>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item>个人信息</el-dropdown-item>
                            <el-dropdown-item>
                                <router-link to="/logout">回到首页</router-link>
                            </el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>
                    <!--                    <span>{{name}}</span>-->
                </el-header>
                <el-main>
                    <!--在这里展示视图-->
                    <router-view/>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>
<script>
    export default {
        // props : ['name'],
        name: "Main"
    }
</script>
<style scoped lang="scss">
    .el-header {
        background-color: #B3C0D1;
        color: rgba(116, 141, 121, 0.93);
        line-height: 60px;
    }

    .el-aside {
        color: rgba(85, 56, 126, 0.87);
    }
</style>
