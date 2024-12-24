<template>

    <ContentBase>
        <ul class="list-group mb-3">
            <li v-for="item in dishs" :key="item.id" class="list-group-item">
                <div class="d-flex justify-content-between align-items-center">
                    <div>
                        <h5 class="mb-1">{{ item.name }}</h5>
                        <ul class="list-unstyled mb-1">
                            <li><strong>价格:</strong> ¥{{ item.price }}</li>
                            <li><strong>味道:</strong> {{ item.taste }}</li>
                            <li><strong>饭堂:</strong> {{ item.carteenId }}</li>
                            <li><strong>窗口:</strong> {{ item.windowId }}</li>
                        </ul>
                    </div>
                    <button @click="fetchbuy(item)" class="btn btn-success btn-sm">添加菜品</button>
                </div>
            </li>
        </ul>
    </ContentBase>

    <ContentBase>
        <h3>当前购物车商品</h3>
        <ul class="list-group mb-3">
            <li v-for="item in shop" :key="item.id" class="list-group-item">
                <div class="d-flex justify-content-between align-items-center">
                    <div>
                        <h5 class="mb-1">{{ item.name }}</h5>
                        <ul class="list-unstyled mb-1">
                            <li><strong>价格:</strong> ¥{{ item.price }}</li>
                            <li><strong>味道:</strong> {{ item.taste }}</li>
                            <li><strong>饭堂:</strong> {{ item.carteenId }}</li>
                            <li><strong>窗口:</strong> {{ item.windowId }}</li>
                        </ul>
                    </div>
                    <button @click="fetchdelect(item)" class="btn btn-danger btn-sm">删除菜品</button>
                </div>
            </li>
        </ul>
        <div class="alert alert-info">总价为：¥{{ sum }}</div>
    </ContentBase>

</template>

<script setup>
import canteen_apiClient from '@/services/canteen_api';
import { ref, onMounted } from 'vue';
import ContentBase from '@/components/ContentBase.vue';
const dishs = ref([]);
const shop = ref([]);
const sum = ref(0);
const fetchdishes = async () => {
    try {
        const response = await canteen_apiClient.post('/show'
        );
        dishs.value = response.data;
    } catch (error) {
        console.log(error);
    }
};
const fetchbuy = (item) => {
    shop.value.push(item);
    sum.value = sum.value + item.price;
};
const fetchdelect = (item) => {
    const idx = shop.value.findIndex(i => i.id === item.id);
    if (idx !== -1) {
        shop.value.splice(idx, 1);
        sum.value -= item.price;
    }
}
onMounted(() => {
    fetchdishes();
});
</script>

<style></style>