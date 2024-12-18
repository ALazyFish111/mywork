import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CafateriaView from '@/views/CafateriaView.vue'
import LoginView from '@/views/LoginView.vue'
import RegisterView from '@/views/RegisterView.vue'
import SearchCafateriaView from '@/views/SearchCafateriaView.vue'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/',
    name: 'cafateria',
    component: CafateriaView
  },
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/',
    name: 'register',
    component: RegisterView
  },
  {
    path: '/',
    name: 'searchcafateria',
    component: SearchCafateriaView
  },

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
