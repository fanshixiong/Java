<template>
    <div>
        <h2 class="title">{{message}}</h2>
        <button @click="btnClick">安妮</button>
        <h1>{{name}}</h1>
        <Cpn/>
    </div>
</template>

<script>
    import Cpn from "./Cpn.vue";

    export default {
        name: "App",
        components: {
            Cpn,
        },
        data() {
            return {
                message: "app-frans1",
                name: 'frans',
            }
        },
        methods: {
            btnClick() {

            }
        }
    }
</script>

<style scoped>
    .title {
        color: #ff3dba;
    }
</style>
