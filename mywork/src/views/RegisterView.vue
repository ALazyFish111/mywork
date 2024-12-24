<template>
    <ContentBase>
        <div class="card p-4 mt-5">
            <div class="card-body">
                <h5 class="card-title text-center mb-4">
                    <span class="text-danger">用户注册</span>
                </h5>
                <form>
                    <div class="mb-3">
                        <input type="text" class="form-control" placeholder="账号名" v-model="tmp.username" required>
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control" placeholder="密码" v-model="tmp.password" required>
                    </div>
                    <div class="mb-3">
                        <input type="password" class="form-control" placeholder="二次密码" v-model="repassword" required>
                    </div>
                    <div class="mb-3">
                        <select class="form-control" v-model="tmp.role" required>
                            <option value="" disabled>选择角色</option>
                            <option value="admin">管理员</option>
                            <option value="user">学生</option>
                        </select>
                    </div>
                    <button @click="click" type="submit" class="btn btn-danger w-100">注册</button>
                </form>

            </div>
        </div>
    </ContentBase>
</template>

<script setup>
import ContentBase from '@/components/ContentBase.vue';
import { useUserStore } from '@/stores/user';
import { reactive } from 'vue';
const userStore = useUserStore();
let repassword;
const tmp = reactive({
    username: '',
    password: '',
    role: '',
})
let msg = true;
const check1 = () => {
    console.log(repassword);
    console.log(tmp.password);
    if (repassword.trim() !== tmp.password.trim()) {
        console.log('信息有误');
        msg = false;
        alert('信息有误');
    }
};
const reForm = () => {
    tmp.username = '';
    tmp.password = '';
    tmp.role = '';
    repassword = '';
}
const click = () => {
    check1();
    if (msg) {
        console.log(tmp.username + ' ' + tmp.password + ' ' + tmp.role);
        userStore.user.password = tmp.password;
        userStore.user.username = tmp.username;
        userStore.user.role = tmp.role;
        console.log(userStore.user);
        userStore.register();
    }
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