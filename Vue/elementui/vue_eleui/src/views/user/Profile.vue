<template>
    <div>
        <h1>个人信息</h1>
        <!--       {{id}}-->
    </div>
</template>

<script>
    export default {
        // props: ['id'],
        name: "Profile",
        beforeRouteEnter: (to, from, next) => {
            console.log("进入路由前");
            //加载数据
            next(vm => {
                vm.getData(); //进入路由之前执行方法
            });
        },
        beforeRouteLeave: (to, from, next) => {
            console.log("出路由前");
            next();
        },
        methods: {
            getData: function () {
                this.axios({
                    methods: 'get',
                    url: 'http://localhost:8080/static/mock/data.json'
                }).then(function (response) {
                    console.log(response)
                });
            }
        }
    }
</script>

<style scoped>

</style>
