<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container">
            <router-link class="navbar-brand" :to="{ name: 'home' }">Myspace</router-link>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <router-link class="nav-link active" :to="{ name: 'home' }">首页</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{ name: 'search' }">饭堂查询</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{ name: 'shop' }">外卖购物</router-link>
                    </li>
                    <li v-if="userStore.user.role == 'admin'" class="nav-item">
                        <router-link class="nav-link" :to="{ name: 'manage' }">信息管理</router-link>
                    </li>
                    <!-- <li v-if="userStore.user.role == 'admin'" class="nav-item">
                        <router-link class="nav-link" :to="{ name: 'addmenu' }">菜品添加</router-link>
                    </li> -->
                </ul>
                <ul v-if="userStore.hasbeen == false" class="navbar-nav">
                    <li class="nav-item">
                        <router-link class="nav-link active" :to="{ name: 'login' }">登录</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link" :to="{ name: 'register' }">注册</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link class="nav-link active" :to="{ name: 'test' }">测试</router-link>
                    </li>

                </ul>
                <ul v-if="userStore.hasbeen == true" class="list-group list-group-flush">
                    <li class="list-group-item">名字：{{ userStore.user.username }}</li>
                    <li class="list-group-item">身份: {{ userStore.user.role }}</li>
                    <li class="list-group-item">
                        <a @click="userStore.resetdata">注销</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script setup>
import { useUserStore } from '@/stores/user';
const userStore = useUserStore();
</script>

<style scoped></style>