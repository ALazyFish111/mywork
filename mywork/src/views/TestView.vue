<template>
    <ContentBase>
        <div class="card p-4 mt-5">
            <div class="card-body">


                <button @click="click" type="submit" class="btn btn-danger w-100">登录</button>
            </div>
        </div>

        <ul class="list-group">
            <li v-for="(item, index) in dates" :key="index">
                <p class="mb-1">菜名: {{ item.name }}</p>
                <p class="mb-1">价格: {{ item.price }}</p>
                <p class="mb-1">味道: {{ item.taste }}</p>
                <p class="mb-1">饭堂: {{ item.carteenId }}</p>
                <p class="mb-1">窗口: {{ item.windowId }}</p>

            </li>
        </ul>
    </ContentBase>
</template>

<script setup>
import ContentBase from '@/components/ContentBase.vue';
import axios from 'axios';
import { ref } from 'vue';
const dates = ref([]);
const click = async () => {
    try {
        const response = await axios.post('http://localhost:3000/test1/01');
        console.log(response);
        dates.value = response.data;
        console.log(dates);
    } catch (error) {
        console.log(error);
        return false;
    }
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