export default {
    template: `
        <div>
            <h2>{{message}}</h2>
            <button @click="btnClick">安妮</button>
            <h1>{{name}}</h1>
        </div>
    `,
    data() {
        return {
            message: "app-frans",
            name: 'frans',
        }
    },
    methods: {
        btnClick() {

        }
    }
}
