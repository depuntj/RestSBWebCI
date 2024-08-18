<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Data</title>
    <link rel="stylesheet" href="<?php echo base_url('assets/css/style.css'); ?>">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .container {
            width: 100%;
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        form {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input, select, button {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            opacity: 0.8;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group select {
            height: auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit Data</h1>

        <?php if (isset($project)): ?>
            <!-- Form for Editing Project -->
            <h2>Edit Project</h2>
            <form action="<?php echo base_url('main/update_project/' . $project->id_pk); ?>" method="post">
                <div class="form-group">
                    <label for="id_pk">Project ID:</label>
                    <input type="number" name="id_pk" id="id_pk" value="<?php echo $project->id_pk; ?>" required readonly>
                </div>

                <div class="form-group">
                    <label for="nama_proyek">Project Name:</label>
                    <input type="text" name="nama_proyek" id="nama_proyek" value="<?php echo $project->nama_proyek; ?>" required>
                </div>

                <div class="form-group">
                    <label for="client">Client:</label>
                    <input type="text" name="client" id="client" value="<?php echo $project->client; ?>" required>
                </div>

                <div class="form-group">
                    <label for="tgl_mulai">Start Date:</label>
                    <input type="date" name="tgl_mulai" id="tgl_mulai" value="<?php echo $project->tgl_mulai; ?>" required>
                </div>

                <div class="form-group">
                    <label for="tgl_selesai">End Date:</label>
                    <input type="date" name="tgl_selesai" id="tgl_selesai" value="<?php echo $project->tgl_selesai; ?>" required>
                </div>

                <div class="form-group">
                    <label for="pimpinan_proyek">Project Leader:</label>
                    <input type="text" name="pimpinan_proyek" id="pimpinan_proyek" value="<?php echo $project->pimpinan_proyek; ?>" required>
                </div>

                <div class="form-group">
                    <label for="keterangan">Description:</label>
                    <input type="text" name="keterangan" id="keterangan" value="<?php echo $project->keterangan; ?>" required>
                </div>

                <div class="form-group">
                    <label for="lokasi">Location:</label>
                    <select name="lokasi[]" id="lokasi" multiple required>
                        <?php foreach ($locations as $location): ?>
                            <option value="<?php echo $location->id_pk; ?>" 
                                <?php echo (isset($project_locations) && in_array($location->id_pk, $project_locations)) ? 'selected' : ''; ?>>
                                <?php echo $location->nama_lokasi; ?>
                            </option>
                        <?php endforeach; ?>
                    </select>
                </div>

                <button type="submit">Update Project</button>
                <button type="button" onclick="window.location.href = '<?php echo base_url('main'); ?>'">Back</button>
            </form>

        <?php elseif (isset($location)): ?>
            <!-- Form for Editing Location -->
            <h2>Edit Location</h2>
            <form action="<?php echo base_url('main/update_location/' . $location->id_pk); ?>" method="post">
                <div class="form-group">
                    <label for="id_pk">Location ID:</label>
                    <input type="number" name="id_pk" id="id_pk" value="<?php echo $location->id_pk; ?>" required readonly>
                </div>

                <div class="form-group">
                    <label for="nama_lokasi">Location Name:</label>
                    <input type="text" name="nama_lokasi" id="nama_lokasi" value="<?php echo $location->nama_lokasi; ?>" required>
                </div>

                <div class="form-group">
                    <label for="negara">Country:</label>
                    <input type="text" name="negara" id="negara" value="<?php echo $location->negara; ?>" required>
                </div>

                <div class="form-group">
                    <label for="provinsi">Province:</label>
                    <input type="text" name="provinsi" id="provinsi" value="<?php echo $location->provinsi; ?>" required>
                </div>

                <div class="form-group">
                    <label for="kota">City:</label>
                    <input type="text" name="kota" id="kota" value="<?php echo $location->kota; ?>" required>
                </div>

                <button type="submit">Update Location</button>
                <button type="button" onclick="window.location.href = '<?php echo base_url('main'); ?>'">Back</button>
                
            </form>

        <?php else: ?>
            <p>No data to edit.</p>
        <?php endif; ?>
    </div>
</body>
</html>
