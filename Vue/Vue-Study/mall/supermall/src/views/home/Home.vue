<template>
  <div id="home">
    <nav-bar class="home-nav">
      <template v-slot:center><div>购物街</div></template>
    </nav-bar>
    <scroll class="content"
            ref="scroll"
            :probe-type="3"
            @scroll="contentScroll"
            :pull-up-load="true"
            @pullingup = "loadMore"
            @pullingdown="homePullingDown"
            :pull-down-refresh=true>
      <home-swiper :banners="banners"/>
      <recommend-view :recommends = "recommends"/>
      <feature-view/>
      <tab-control class="tab-control" :titles="[`流行`,`新款`,`精选`]" @tabclick="tabclick"/>
      <goods-list :goods="showGoods"/>
      <ul>
        <li>pic1</li>
        <li>pic2</li>
        <li>pic3</li>
        <li>pic4</li>
        <li>pic5</li>
        <li>pic6</li>
        <li>pic7</li>
        <li>pic8</li>
        <li>pic9</li>
        <li>pic10</li>
        <li>pic11</li>
        <li>pic12</li>
        <li>pic13</li>
        <li>pic14</li>
        <li>pic15</li>
        <li>pic16</li>
        <li>pic17</li>
        <li>pic18</li>
        <li>pic19</li>
        <li>pic20</li>
        <li>pic21</li>
        <li>pic22</li>
        <li>pic23</li>
        <li>pic24</li>
        <li>pic25</li>
        <li>pic26</li>
        <li>pic27</li>
        <li>pic28</li>
        <li>pic29</li>
        <li>pic30</li>
        <li>pic31</li>
        <li>pic32</li>
        <li>pic33</li>
        <li>pic34</li>
        <li>pic35</li>
        <li>pic36</li>
        <li>pic37</li>
        <li>pic38</li>
        <li>pic39</li>
        <li>pic40</li>
        <li>pic41</li>
        <li>pic42</li>
        <li>pic43</li>
        <li>pic44</li>
        <li>pic45</li>
        <li>pic46</li>
        <li>pic47</li>
        <li>pic48</li>
        <li>pic49</li>
        <li>pic50</li>
        <li>pic51</li>
        <li>pic52</li>
        <li>pic53</li>
        <li>pic54</li>
        <li>pic55</li>
        <li>pic56</li>
        <li>pic57</li>
        <li>pic58</li>
        <li>pic59</li>
        <li>pic60</li>
        <li>pic61</li>
        <li>pic62</li>
        <li>pic63</li>
        <li>pic64</li>
        <li>pic65</li>
        <li>pic66</li>
        <li>pic67</li>
        <li>pic68</li>
        <li>pic69</li>
        <li>pic70</li>
        <li>pic71</li>
        <li>pic72</li>
        <li>pic73</li>
        <li>pic74</li>
        <li>pic75</li>
        <li>pic76</li>
        <li>pic77</li>
        <li>pic78</li>
        <li>pic79</li>
        <li>pic80</li>
        <li>pic81</li>
        <li>pic82</li>
        <li>pic83</li>
        <li>pic84</li>
        <li>pic85</li>
        <li>pic86</li>
        <li>pic87</li>
        <li>pic88</li>
        <li>pic89</li>
        <li>pic90</li>
        <li>pic91</li>
        <li>pic92</li>
        <li>pic93</li>
        <li>pic94</li>
        <li>pic95</li>
        <li>pic96</li>
        <li>pic97</li>
        <li>pic98</li>
        <li>pic99</li>
        <li>pic100</li>
      </ul>
    </scroll>
    <back-top @click = "backClick" v-show="isShowBackTop"/>

  </div>
</template>

<script>
// <!--封装的子组件-->
import HomeSwiper from './childComps/HomeSwiper'
import RecommendView from './childComps/RecommendView'
import FeatureView from './childComps/FeatureView'
// 公共组件
import NavBar from 'components/common/navbar/NavBar'
import TabControl from 'components/content/tabControl/TabControl'
import GoodsList from 'components/content/goods/GoodsList'
import Scroll from 'components/common/scroll/Scroll'
import BackTop from 'components/common/backTop/BackTop'
// 工具函数
import { getHomeMultidata, getHomeGoods } from 'network/home'

export default {
  name: 'Home',
  components: {
    NavBar,
    HomeSwiper,
    RecommendView,
    FeatureView,
    TabControl,
    GoodsList,
    Scroll,
    BackTop
  },
  data () {
    return {
      banners: [],
      recommends: [],
      goods: {
        pop: { page: 0, list: [] },
        new: { page: 0, list: [] },
        sell: { page: 0, list: [] }
      },
      currentType: 'pop',
      isShowBackTop: false
    }
  },
  computed: {
    showGoods () {
      return this.goods[this.currentType].list
    }
  },
  methods: {
    /**
     * 事件监听相关方法
     *
     * */
    tabclick (index) {
      console.log(index)
      this.currentType = Object.keys(this.goods)[index]
    },
    backClick () {
      // this.$refs.scroll.scroll.scrollTo(0, 0)
      this.$refs.scroll.scrollTo(0, 0)
    },
    contentScroll (position) {
      this.isShowBackTop = -position.y > 1000
    },
    loadMore () {
      console.log('上拉加载更多')
      this.getHomeGoods(this.currentType)
    },
    /**
     * 网络请求相关的方法
     */
    getHomeMultidata () {
      getHomeMultidata().then(res => {
        this.banners = res.data.banner
        this.recommends = res.data.recommend
      })
    },
    getHomeGoods (type) {
      const page = this.goods[type].page + 1
      getHomeGoods(type, page).then(res => {
        this.goods[type].list.push(...res.data.list)
        this.goods[type].page += 1
      })
    }
  },
  // 组件创建好就请求数据
  created () {
    // 1、请求多个数据
    this.getHomeMultidata()

    // 2、请求商品数据
    this.getHomeGoods('pop')
    this.getHomeGoods('new')
    this.getHomeGoods('sell')

    // 3.监听item中图片加载完成
    this.$bus.$on('imgloadrefresh', () => {
      this.$refs.scroll.refresh()
    })
  }
}
</script>

<style scoped>
#home {
  margin-bottom: 49px;
  overflow: hidden;
}

.home-nav-bar {
  color: white;
  background-color: var(--color-tint);
}

.tab-control {
  position: relative;
  z-index: 9;
}

.tab-control2 {
  position: fixed;
  margin-top: -1px;
  width: 100%;
}

.content {
  position: relative;
  height: calc(100vh - 93px);
  overflow: hidden;
}

.refreshMsg {
  width: 100%;
  height: 40px;
  position: absolute;
  line-height: 40px;
  text-align: center;
  color: rgba(0, 0, 0, 0.5);
  font-style: oblique;
}
</style>
