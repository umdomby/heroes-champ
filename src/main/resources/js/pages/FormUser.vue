<template>

  <div class="container">
    <form class="card">
      <h2>Settings account</h2>
      <div class="form-control">
        <label for="name">Name:</label>
        <input type="text" id="name" v-model.trim="name">
      </div>
      <button class="btn primary" :disabled="name.length === 0">Add login Heroes</button>
    </form>
  </div>


</template>

<script>

export default {
  name: "FormUser",
  data(){
    return{
      name: ''
    }
  }
}
</script>

<style scoped>

</style>