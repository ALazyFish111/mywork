<template>
    <ContentBase>
        <div class="card p-4 mt-5">
            <div class="card-body">
                <h5 class="card-title text-center mb-4">
                    <span class="text-danger">密码登录</span>
                </h5>
                <form>
                    <div class="mb-3">
                        <input type="text" class="form-control" placeholder="账号名" v-model="tmp.username" required>
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control" placeholder="密码" v-model="tmp.password" required>
                    </div>
                    <div class="d-flex justify-content-between mb-3">
                        <a href="#" class="text-muted">忘记密码</a>
                    </div>
                    <button @click="click" type="submit" class="btn btn-danger w-100">登录</button>
                </form>
                <div class="text-center mt-3">
                    <router-link class="text-muted" :to="{ name: 'register' }">立即注册</router-link>
                </div>
                <div class="text-center mt-3">
                    <router-link class="text-muted" :to="{ name: 'home' }">跳转到首页</router-link>
                </div>
            </div>
        </div>
    </ContentBase>
</template>

<script setup>
import ContentBase from '@/components/ContentBase.vue';
import { useUserStore } from '@/stores/user';
import { reactive } from 'vue';
const userStore = useUserStore();

const tmp = reactive({
    username: '',
    password: '',
})

const reForm = () => {
    tmp.username = '';
    tmp.password = '';
}
const click = () => {

    userStore.user.username = tmp.username;
    userStore.user.password = tmp.password;
    console.log(tmp);
    userStore.login();
    reForm();
}

</script>
<style scoped>
.card {
    max-width: 400px;
    margin: 0 auto;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>