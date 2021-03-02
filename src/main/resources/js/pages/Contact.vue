<template>
  <v-container>
    <v-layout align-space-around justify-start column>
      <div>
        <h1>Hello Contact</h1>
      </div>
    </v-layout>
  </v-container>
</template>

<script>
  export default {
    name: "Contact"
  }
</script>

<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>