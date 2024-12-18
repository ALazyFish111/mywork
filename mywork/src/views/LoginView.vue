<template>
    <ConteneBase>
        <div class="login-type">
            <span class="active">登录</span>
        </div>
        <form @submit.prevent="submitForm">
            <div class="mb-3">
                <input v-model = "formdate.username" type="text" class="form-control" placeholder="账号名" required>
            </div>
            <div class="mb-3">
                <input v-model = "formdate.password" type="password" class="form-control" placeholder="密码" required>
            </div>
            <div class="forgot-password">
                <a href="#">注册</a>
            </div>
            <div class="d-grid gap-2 mt-4">
                <button type="submit" class="btn btn-login">登 录</button>
            </div>
        </form>
        <p v-if="message">"账号或密码错误"</p>
    </ConteneBase>

</template>
  
<script>
import axios from 'axios';
import {ref,reactive} from 'vue';
import ConteneBase from '@/components/ConteneBase.vue';

import router from '@/router';
// import HomeView from './HomeView.vue';
export default{
    name:'LoginView',
    components:{
        ConteneBase,
    },
    setup(){
        let formdate = reactive({
            username:'',
            password:'',
            role:''
        })
        const message = ref('')
        const resetForm = () => {
            formdate.username = ''
            formdate.password = ''
        };
        
        const submitForm = async() =>{
            try{
                const response = await axios.post('http://localhost:3000/test',formdate);
                message.value = 'false'
                if(response.data == true){
                    router.push({name:'home'})
                }
            }catch(error){
                message.value = 'false'
            }
        };
        

        return {
            formdate,
            message,
            resetForm,
            submitForm
        };
    }
}
</script>

<style>
        body {
            background-color: #f8f9fa;
        }
        .login-type{
            text-align: center;
        }
        .login-container {
            max-width: 400px;
            margin: 50px auto;
        }
        .login-type {
            margin-bottom: 20px;
        }
        .login-type span {
            font-size: 18px;
            margin-right: 15px;
            cursor: pointer;
        }
        .login-type span.active {
            color: #dc3545;
            font-weight: bold;
        }
        .form-control {
            background-color: #f1f3f5;
            border: none;
            padding: 12px;
        }
        .forgot-password {
            text-align: right;
            margin-top: 10px;
        }
        .forgot-password a {
            color: #6c757d;
            text-decoration: none;
        }
</style>