<template>
  <NavBar></NavBar>
  <router-view/>
</template>

<script>
  import NavBar from './components/NarBar.vue';
  export default{
    name:"App",
    components:{
      NavBar,
    }
  }
</script>
<style>

</style>
