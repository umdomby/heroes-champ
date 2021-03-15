<template>
  <v-layout row>
    <v-text-field
        label="New contact"
        placeholder="Write something"
        v-model="text"
    />
    <v-btn @click="save">
      Save
    </v-btn>
  </v-layout>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  props: ['contactAttr'],
  data() {
    return {
      text: '',
      id: ''
    }
  },
  watch: {
    contactAttr(newVal, oldVal) {
      this.text = newVal.text
      this.id = newVal.id
    }
  },
  methods: {
    ...mapActions(['addContactAction', 'updateContactAction']),
    save() {
      const contact = {
        id: this.id,
        text: this.text
      }

      if (this.id) {
        this.updateContactAction(contact)
      } else {
        this.addContactAction(contact)
      }

      this.text = ''
      this.id = ''
    }
  }
}
</script>

<style>

</style>
