<template>
  <div class="rapper" ref="rapper">
    <div class="content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
import BScroll from 'better-scroll'
export default {
  name: 'Scroll',
  data () {
    return {
      scroll: null
    }
  },
  props: {
    probeType: {
      type: Number,
      default: 0
    },
    pullUpLoad: {
      type: Boolean,
      default: false
    },
    pullDownRefresh: {
      type: Boolean,
      default: false
    },
    pullDownRefreshStop: {
      type: Number,
      default: 0
    }
  },
  mounted () {
    this.scroll = new BScroll(this.$refs.wrapper, {
      probeType: this.probeType,
      pullUpLoad: {
        boolean: this.pullUpLoad,
        //设置上拉多大距离才能触发方法
        threshold: -100
      },
      pullDownRefresh: {
        boolean: this.pullDownRefresh,
        threshold: 40,
        //刷新数据的过程中，回弹停留在距离顶部还有40px的位置
        stop: this.pullDownRefreshStop
      },
      click: true
    })
  }
}
</script>

<style scoped>

</style>
