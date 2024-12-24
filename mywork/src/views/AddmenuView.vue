<template>
    <div>
        <h1>添加菜品</h1>
        <div class="mb-3">
            <label for="canteenId" class="form-label">饭堂编号</label>
            <input id="canteenId" type="number" v-model="dish.carteenId" class="form-control" placeholder="输入饭堂编号" />
        </div>
        <div class="mb-3">
            <label for="windowId" class="form-label">窗口编号</label>
            <input id="windowId" type="number" v-model="dish.windowId" class="form-control" placeholder="输入窗口编号" />
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">菜品名称</label>
            <input id="name" type="text" v-model="dish.name" class="form-control" placeholder="输入菜品名称" />
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">菜品价格</label>
            <input id="price" type="number" v-model="dish.price" class="form-control" placeholder="输入菜品价格" />
        </div>
        <div class="mb-3">
            <label for="taste" class="form-label">菜品口味</label>
            <input id="taste" type="text" v-model="dish.taste" class="form-control" placeholder="输入菜品口味" />
        </div>
        <button @click="submitDish" class="btn btn-primary">提交</button>
    </div>
</template>

<script setup>
import canteen_apiClient from '@/services/canteen_api';
import { reactive } from 'vue';
const dish = reactive({
    carteenId: '',
    windowId: '',
    name: '',
    price: '',
    taste: '',
})

const reset = () => {
    dish.carteenId = '';
    dish.windowId = '';
    dish.name = '';
    dish.price = '';
    dish.taste = '';
}
const submitDish = async () => {
    try {
        console.log(dish);
        const response = await canteen_apiClient.post('/adddish', dish);
        console.log(response.data);
        reset();
    } catch (error) {
        console.log(error);
        return false;
    }
}
</script>

<style></style>