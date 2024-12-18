<template>
  
  <ConteneBase>
    <div class="row">
      <div class="col-3">
        这是我的头像
      </div>
      <div class="col-9">
        这是我的信息
      </div>
    </div>
  </ConteneBase>
</template>

<script>
import ConteneBase from '@/components/ConteneBase.vue';
export default {
  name: 'HomeView',
  components: {
    ConteneBase,
  }
}
</script>
