import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import SearchView from '@/views/SearchView.vue'
import RegisterView from '@/views/RegisterView.vue'
import ShopView from '@/views/ShopView.vue'
import LoginView from '@/views/LoginView.vue'
import TestView from '@/views/TestView.vue'
import ManageView from '@/views/ManageView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/',
    name: 'search',
    component: SearchView
  },
  {
    path: '/',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/',
    name: 'shop',
    component: ShopView
  },
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/',
    name: 'test',
    component: TestView
  },
  {
    path: '/',
    name: 'manage',
    component: ManageView
  },

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
