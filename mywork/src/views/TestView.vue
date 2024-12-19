<template>
    <ContentBase>
        <div class="card p-4 mt-5">
            <div class="card-body">


                <button @click="test" type="submit" class="btn btn-danger w-100">登录</button>
            </div>
        </div>
    </ContentBase>
</template>

<script setup>
// import apiClient from '@/services/api';
import ContentBase from '@/components/ContentBase.vue';
// import { reactive } from 'vue';
import { useRouter } from 'vue-router';
// const user = reactive({
//     id: 0,
//     username: 'exampleUsername',
//     password: 'examplePassword',
//     role: 'exampleRole'
// });
const router = useRouter();
const test = () => {

    router.push('/home');
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