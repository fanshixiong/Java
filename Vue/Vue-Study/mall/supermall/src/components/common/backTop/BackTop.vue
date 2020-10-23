<template>
  <div class="back_top">
    <img src="~assets/img/common/top.png" alt="回到顶部">
  </div>
</template>

<script>
export default {
  name: 'BackTop'
}
</script>

<style scoped>
.back_top{
  position: fixed;
  bottom: 49px;
  right: 10px;
  cursor: pointer;
}
.back_top img{
  width: 50px;
  height: 50px;
}
</style>
