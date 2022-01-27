from django.db import models


class Person(models.Model):
    class Meta:
        db_table = "people"

    first_name = models.CharField(max_length=128)
    second_name = models.CharField(max_length=128)
    surname = models.CharField(max_length=128)

    def __str__(self):
        return self.first_name + " " + self.second_name + ", " + self.surname
