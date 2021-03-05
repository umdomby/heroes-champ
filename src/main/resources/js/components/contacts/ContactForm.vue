<template>
  <div>
    <input type="text" placeholder="Write something" v-model="text" />
    <input type="button" value="Save" @click="save" />
  </div>
</template>

<script>
import contactsApi from "api/contacts";

export default {
  props: ['contacts', 'contactAttr'],
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
    save() {
      const contact = {
        id: this.id,
        text: this.text }

      if (this.id) {
        contactsApi.update(contact).then(result =>
            result.json().then(data => {
              const index = this.contacts.findIndex(item => item.id === data.id)
              this.contacts.splice(index, 1, data)
            })
        )
      } else {
        contactsApi.add(contact).then(result =>
            result.json().then(data => {
              const index = this.contacts.findIndex(item => item.id === data.id)
              if(index > -1){
                this.contacts.splice(index, 1, data)
              }else{
                this.contacts.push(data)
              }
            })
        )
      }
      this.text = ''
      this.id = ''
    }
  }
}
</script>

<style>

</style>
