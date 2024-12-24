<template>
    <ul class="list-group">
        <li v-for="item in dishs" :key="item.id" class="list-group-item">
            <div class="d-flex justify-content-between align-items-start">
                <div>
                    <h5 class="mb-1">{{ item.name }}</h5>
                    <ul class="list-unstyled mb-1">
                        <li><strong>价格:</strong> ¥{{ item.price }}</li>
                        <li><strong>味道:</strong> {{ item.taste }}</li>
                        <li><strong>饭堂:</strong> {{ item.carteenId }}</li>
                        <li><strong>窗口:</strong> {{ item.windowId }}</li>
                    </ul>
                </div>
                <button @click="fetchDelete(item.id)" class="btn btn-danger btn-sm">删除菜品</button>
            </div>
        </li>
    </ul>

</template>

<script setup>
import canteen_apiClient from '@/services/canteen_api';
import { ref, onMounted } from 'vue';
const dishs = ref([]);
const fetchdishes = async () => {
    try {
        const response = await canteen_apiClient.post('/show'
        );
        dishs.value = response.data;
    } catch (error) {
        console.log(error);
    }
};
const fetchDelete = async (id) => {
    try {
        console.log(id);
        const response = await canteen_apiClient.post('/delete', id
        );
        console.log(response.data);
        dishs.value = response.data;
    } catch (error) {
        console.log(error);
    }
};
onMounted(() => {
    fetchdishes();
});

</script>

<style></style>