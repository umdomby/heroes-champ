<template>
  <v-card class="my-2">
    <v-card-text primary-title>
      <i>({{ contact.id }})</i>
      {{ contact.text }}
    </v-card-text>
    <v-card-actions>
      <v-btn value="Edit" @click="edit" small flat round>Edit</v-btn>
      <v-btn icon @click="del" small>
        <v-icon>delete</v-icon>
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  props: ['contact', 'editContact'],
  methods: {
    ...mapActions(['removeContactAction']),
    edit() {
      this.editContact(this.contact)
    },
    del() {
      this.removeContactAction(this.contact)
    }
  }
}
</script>

<style>

</style>
