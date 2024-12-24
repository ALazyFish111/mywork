<template>
    <ContentBase>
        <div class="mb-3">
            <label for="canteenSelect" class="form-label">选择饭堂</label>
            <select id="canteenSelect" class="form-select" v-model="idquest.CanteenId" @change="fetchWindows">
                <option v-for="canteen in selectCanteen" :key="canteen.id" :value="canteen.id">
                    {{ canteen.name }}
                </option>
            </select>
        </div>

        <div class="mb-3">
            <label for="windowSelect" class="form-label">选择窗口</label>
            <select id="windowSelect" class="form-select" v-model="idquest.WindowId">
                <option v-for="window in windows" :key="window.id" :value="window.id">
                    {{ window.name }}
                </option>
            </select>
        </div>

        <div class="mb-3">
            <label for="sortSelect" class="form-label">价格排序</label>
            <select id="sortSelect" class="form-select" v-model="sortOption">
                <option value="none">不排序</option>
                <option value="desc">降序</option>
            </select>
        </div>

        <button @click="fetchData" class="btn btn-primary mb-4">查询</button>

        <ul class="list-group">
            <li v-for="item in dishs" :key="item.id" class="list-group-item">
                <h5 class="mb-1">{{ item.name }}</h5>
                <ul class="list-unstyled mb-1">
                    <li><strong>价格:</strong> ¥{{ item.price }}</li>
                    <li><strong>味道:</strong> {{ item.taste }}</li>
                </ul>
            </li>
        </ul>
        <!-- <p>选择的饭堂ID: {{ idquest.CanteenId }}</p>
        <p>选择的窗口ID: {{ idquest.WindowId }}</p> -->
    </ContentBase>
    <ContentBase>
        <div class="input-group mb-3">
            <input v-model="searchQuery" class="form-control" placeholder="输入搜索信息" />
            <button @click="search" class="btn btn-primary">搜索</button>
        </div>

        <ul class="list-group">
            <li v-for="item in results" :key="item.id" class="list-group-item">
                <h5 class="mb-1">{{ item.name }}</h5>
                <ul class="list-unstyled mb-1">
                    <li><strong>价格:</strong> ¥{{ item.price }}</li>
                    <li><strong>味道:</strong> {{ item.taste }}</li>
                    <li><strong>饭堂:</strong> {{ item.carteenId }}</li>
                    <li><strong>窗口:</strong> {{ item.windowId }}</li>
                </ul>
            </li>
        </ul>
    </ContentBase>
    <ContentBase>
        <div class="mb-3">
            <label for="minPrice" class="form-label">价格大于</label>
            <input id="minPrice" type="number" v-model="priceRange.min" class="form-control" placeholder="最低价格" />
        </div>
        <div class="mb-3">
            <label for="maxPrice" class="form-label">价格小于</label>
            <input id="maxPrice" type="number" v-model="priceRange.max" class="form-control" placeholder="最高价格" />
        </div>
        <button @click="submitPriceRange" class="btn btn-primary">提交价格范围</button>

        <ul class="list-group">
            <li v-for="item in range_results" :key="item.id" class="list-group-item">
                <h5 class="mb-1">{{ item.name }}</h5>
                <ul class="list-unstyled mb-1">
                    <li><strong>价格:</strong> ¥{{ item.price }}</li>
                    <li><strong>味道:</strong> {{ item.taste }}</li>
                    <li><strong>饭堂:</strong> {{ item.carteenId }}</li>
                    <li><strong>窗口:</strong> {{ item.windowId }}</li>
                </ul>
            </li>
        </ul>
    </ContentBase>
</template>

<script setup>
import ContentBase from '@/components/ContentBase.vue';
import canteen_apiClient from '@/services/canteen_api';
import { ref, onMounted, reactive } from 'vue';
const idquest = reactive({
    CanteenId: null,
    WindowId: null,
})
const priceRange = reactive({
    min: null,
    max: null,
})
const selectCanteen = ref([]);
const windows = ref([]);
const dishs = ref([]);
const results = ref([]);
const range_results = ref([]);
const sortOption = ref('');
const searchQuery = ref('');
// const CanteenId = ref('');

// const WindowId = ref('');

const fetchCanteens = async () => {
    try {
        const response = await canteen_apiClient.post('/allcanteen');
        selectCanteen.value = response.data;
    } catch (error) {
        console.log(error);
    }
};

const fetchWindows = async () => {
    if (!idquest.CanteenId) {
        windows.value = [];
        return;
    }

    try {
        const response = await canteen_apiClient.post('/showwindow', {
            CanteenId: idquest.CanteenId,
            WindowId: idquest.WindowId,
        });
        windows.value = response.data;
    } catch (error) {
        console.log(error);
    }
};

const fetchData = async () => {
    if (!idquest.CanteenId || !idquest.WindowId) {
        alert("缺少信息");
        dishs.value = [];
        return;
    }

    try {
        let url = '/showdish';
        if (sortOption.value === 'desc') {
            url = '/descshowdish';
        }
        const response = await canteen_apiClient.post(url, {
            CanteenId: idquest.CanteenId,
            WindowId: idquest.WindowId,
        });
        dishs.value = response.data;
    } catch (error) {
        console.log(error);
    }
};
const search = async () => {
    try {
        console.log(searchQuery);
        const response = await canteen_apiClient.post('/findbylikename',
            searchQuery.value
        );
        results.value = response.data;
    } catch (error) {
        console.log(error);
    }
}
const submitPriceRange = async () => {
    try {
        const response = await canteen_apiClient.post('/invertPrice',
            priceRange
        );
        range_results.value = response.data;
    } catch (error) {
        console.log(error);
    }
}
onMounted(() => {
    fetchCanteens();
});
</script>

<style scoped></style>