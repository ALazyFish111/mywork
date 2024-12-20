import { defineStore } from "pinia";
import { ref, reactive } from "vue";
import apiClient from "@/services/api";
// import router from "@/router";

export const useUserStore = defineStore('user', () => {
    let user = reactive({
        username: '',
        password: '',
        role: '',
    })
    let hasbeen = ref(false)
    const resetdata = () => {
        user.username = '';
        user.password = '';
        user.role = '';
        hasbeen = false;
    };
    const register_check = async () => {
        try {
            const response = await apiClient.post('/register_check', user.username);
            return response.data.exists;
        } catch (error) {
            console.log(error);
            return false;
        }
    }
    const register = async () => {
        try {
            const exists = await register_check();
            console.log(exists);
            if (!exists) {
                alert('注册失败，该账号已存在');
            } else {
                const response = await apiClient.post('/register_add',
                    useUserStore.user
                );
                alert('注册成功');
                console.log(response.data);
            }
        } catch (error) {
            console.log(error);
            alert("注册失败,请输入正确的信息")
        }
    }

    const login_check = async () => {
        try {
            console.log(user.username);
            console.log(user.password);
            const response = await apiClient.post('/login_check', user);
            return response.data.exists;
        } catch (error) {
            console.log(error);
            return false;
        }
    }
    const login = async () => {
        try {
            const exists = await login_check();
            console.log(exists);
            if (!exists) {
                alert('账号或密码输入有误');
            } else {
                hasbeen = true;
            }
        } catch (error) {
            console.log(error);
            alert("账号或密码输入有误")
        }
    }
    const logout = () => {
        resetdata;
    }
    return {
        user, hasbeen,
        resetdata, login,
        logout, register,
        register_check,
        login_check,
    }
});
