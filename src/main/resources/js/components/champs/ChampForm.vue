<template>
  <v-layout row>
    <v-text-field
        label="New champ"
        placeholder="Write something"
        v-model="text"
    />
    <v-btn @click="save">
      ADD
    </v-btn>
  </v-layout>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  props: ['champAttr'],
  data() {
    return {
      text: '',
      id: ''
    }
  },
  watch: {
    champAttr(newVal, oldVal) {
      this.text = newVal.text
      this.id = newVal.id
    }
  },
  methods: {
    ...mapActions(['addChampAction', 'updateChampAction']),
    save() {
      const champ = {
        id: this.id,
        text: this.text
      }

      if (this.id) {
        this.updateChampAction(champ)
      } else {
        this.addChampAction(champ)
      }

      this.text = ''
      this.id = ''
    }
  }
}
</script>

<style>

</style>
